import React from "react"
import useListEvents from "../../state/hooks/useEventsList"
import Evento from "../Evento"
import Filtro from "../Filtro"
import style from "./ListaDeEventos.module.scss"

const ListaDeEventos: React.FC = () => {
  const displayEvents = useListEvents()
  return (
    <section>
      <Filtro />
      <div className={style.Scroll}>
        {displayEvents.map((evento) => (
          <Evento evento={evento} key={evento.id} />
        ))}
      </div>
    </section>
  )
}

export default ListaDeEventos
