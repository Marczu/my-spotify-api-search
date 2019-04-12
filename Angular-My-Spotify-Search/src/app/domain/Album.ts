import {Images} from "./Images";

export class Album {
  constructor(
    public release_date: string,
    public total_tracks: string,
    public name: string,
    public images: Images[]
  ) {
  }
}
