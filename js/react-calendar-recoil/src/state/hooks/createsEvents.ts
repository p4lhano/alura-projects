import { useSetRecoilState } from "recoil"
import { listEventsState } from "../atom"

const useAddEvent = () => {
  const setList = useSetRecoilState(listEventsState)
  // setList
}
