import { selector } from "recoil"
import { filterEvents, listEventsState } from "../atom"

export const filtredEventsState = selector({
  key: "filtredEventsState",
  get: ({ get }) => {
    const filter = get(filterEvents)
    const allEvents = get(listEventsState)
    const displayEvents = allEvents.filter((evt) =>
      !filter.data
        ? true
        : filter.data.toISOString().slice(0, 10) ===
          evt.inicio.toISOString().slice(0, 10)
    )

    return displayEvents
  },
})
