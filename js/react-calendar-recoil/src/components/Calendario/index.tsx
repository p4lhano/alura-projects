import Kalend, { CalendarEvent, CalendarView, OnEventDragFinish } from "kalend"
import "kalend/dist/styles/index.css"
import React from "react"
import { useRecoilValue, useSetRecoilState } from "recoil"
import { listEventsState } from "../../state/atom"
import style from "./Calendario.module.scss"
import ptBR from "./localizacao/ptBR.json"

interface IKalendEvento {
  id?: number
  startAt: string
  endAt: string
  summary: string
  color: string
}

const Calendario: React.FC = () => {
  const eventosKalend = new Map<string, IKalendEvento[]>()
  const setEventList = useSetRecoilState(listEventsState)

  const eventos = useRecoilValue(listEventsState)

  eventos.forEach((evento) => {
    const chave = evento.inicio.toISOString().slice(0, 10)
    if (!eventosKalend.has(chave)) {
      eventosKalend.set(chave, [])
    }
    eventosKalend.get(chave)?.push({
      id: evento.id,
      startAt: evento.inicio.toISOString(),
      endAt: evento.fim.toISOString(),
      summary: evento.descricao,
      color: "blue",
    })
  })
  const onEventDragFinish: OnEventDragFinish = (
    prevEvent: CalendarEvent,
    updatedEvent: CalendarEvent,
    events: any
  ) => {
    const evt = eventos.find((e) => e.descricao === prevEvent.summary)
    if (!evt) return

    setEventList((list) => {
      const ind = list.findIndex((e) => e.id === evt.id)
      return [
        ...list.slice(0, ind),
        {
          ...evt,
          inicio: new Date(updatedEvent.startAt),
          fim: new Date(updatedEvent.endAt),
        },
        ...list.slice(ind + 1),
      ]
    })
  }
  return (
    <div className={style.Container}>
      <Kalend
        events={Object.fromEntries(eventosKalend)}
        initialDate={new Date().toISOString()}
        hourHeight={60}
        initialView={CalendarView.MONTH}
        timeFormat={"24"}
        weekDayStart={"Monday"}
        calendarIDsHidden={["work"]}
        language={"customLanguage"}
        customLanguage={ptBR}
        onEventDragFinish={onEventDragFinish}
      />
    </div>
  )
}

export default Calendario
