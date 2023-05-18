
docker network create alura-net
#subir varias instacias
docker run -d --rm --net alura-net --hostname rabbit1 --name rabbit1 -p 8085:15672 -e RABBITMQ_ERLANG_COOKIE=alura_secret rabbitmq:3.10-management
docker run -d --rm --net alura-net --hostname rabbit2 --name rabbit2 -p 8086:15672 -e RABBITMQ_ERLANG_COOKIE=alura_secret rabbitmq:3.10-management
docker run -d --rm --net alura-net --hostname rabbit3 --name rabbit3 -p 8087:15672 -e RABBITMQ_ERLANG_COOKIE=alura_secret rabbitmq:3.10-management


#Preparar cluster
# 1. parar o cluster
docker exec -it rabbit2 rabbitmqctl stop_app

# 2. reset para configurao o cluster
docker exec -it rabbit2 rabbitmqctl reset

# 3. Juntando a instacia no cluster
docker exec -it rabbit2 rabbitmqctl join_cluster rabbit@rabbit1

# 4. Iniciar app
docker exec -it rabbit2 rabbitmqctl start_app

# 5. mesma coisa para a outra instacia [3]
docker exec -it rabbit3 rabbitmqctl stop_app
docker exec -it rabbit3 rabbitmqctl reset
docker exec -it rabbit3 rabbitmqctl join_cluster rabbit@rabbit1
docker exec -it rabbit3 rabbitmqctl start_app

# ainda necessecita da configuração da mirrored queues