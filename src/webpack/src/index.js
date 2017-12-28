import _ from "lodash";
import {esModule} from "./esModule";

function component() {
    console.log("component1");
    var element = document.createElement('div');
    element.innerHTML = _.join(['Hello', 'webpack'], ' ');
    return element;
}

function component2() {
    console.log("component2");
    var element = document.createElement('div');
    element.innerHTML = _.join([new esModule().sayHello()], ' ');
    return element;
}

document.body.appendChild(component());
document.body.appendChild(component2());