import {Album} from "./Album";
import {Artists} from "./Artists";


export class Items {

  constructor(
    public name: string,
    public album: Album,
    public artists: Artists,
    public duration_ms: number

  )
  {}

}
