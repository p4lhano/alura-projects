import { atom } from "recoil"
import { IFilterEvents } from "../components/Filtro/IFilterEvents"
import { IEvento } from "../interfaces/IEvento"

export const listEventsState = atom<IEvento[]>({
  key: "listEventsState",
  default: [
    {
      descricao: "Estudar React",
      inicio: new Date("2023-04-15T09:00"),
      fim: new Date("2023-04-15T13:00"),
      completo: false,
      id: 1642342747,
    },
    {
      descricao: "Estudar Recoil",
      inicio: new Date("2023-04-16T09:00"),
      fim: new Date("2023-04-16T11:00"),
      completo: false,
      id: 1642342959,
    },
  ],
})

export const filterEvents = atom<IFilterEvents>({
  key: "filterEvents",
  default: { data: null },
})
