import {Album} from "./Album";
import {Artists} from "./Artists";

export class Logs {

  constructor(
    public id: string,
    public log: string,
    public timestamp: Date,
  )
  {}

}
