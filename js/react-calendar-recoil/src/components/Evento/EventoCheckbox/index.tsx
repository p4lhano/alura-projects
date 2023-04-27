import React from "react"
import { useSetRecoilState } from "recoil"
import { IEvento } from "../../../interfaces/IEvento"
import { listEventsState } from "../../../state/atom"

const EventoCheckbox: React.FC<{
  evento: IEvento
}> = ({ evento }) => {
  const estilos = [
    "far",
    "fa-2x",
    evento.completo ? "fa-check-square" : "fa-square",
  ]
  const setEventList = useSetRecoilState(listEventsState)

  const aoAlterarStatus = () => {
    setEventList((list) => {
      const ind = list.findIndex((e) => e.id === evento.id)
      return [
        ...list.slice(0, ind),
        { ...evento, completo: !evento.completo },
        ...list.slice(ind + 1),
      ]
    })
  }

  return <i className={estilos.join(" ")} onClick={() => aoAlterarStatus()}></i>
}

export default EventoCheckbox
