import {Total} from "./Total";
import {Images} from "./Images";


export class ArtistsItems {

  constructor(
    public id: string,
    public name: string,
    public images: Images[],
    public followers: Total,
  )
  {}

}
