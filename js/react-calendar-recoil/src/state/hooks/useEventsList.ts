import { useRecoilValue } from "recoil"
import { filtredEventsState } from "../selecters"

const useListEvents = () => {
  return useRecoilValue(filtredEventsState)
}

export default useListEvents
