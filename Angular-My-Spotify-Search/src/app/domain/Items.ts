import {Album} from "./Album";


export class Items {

  constructor(
    public name: string,
    public album: Album,
    public duration_ms: number
  ) {
  }

}
