import {Demo} from "./es6Module";

export class HelloModule {
    constructor() {
        console.log(new Demo().hello());
    }
}