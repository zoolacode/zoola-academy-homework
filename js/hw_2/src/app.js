import { h, createProjector } from "maquette";

const projector = createProjector();

/**
 * Using h('div.main') will create a <div class="main" /> element.
 * Using h('div.main', [h('div.slots')]) will create <div class="main"><div class="slots"></div></div> structure
 * Using h('div.main', { style }, [h('div.slots')]) will create <div class="main"><div class="slots"></div></div> structure
 * Additional HTML attributes can be passed as an OPTIONAL second parameter:
 *    h('div.main', {
 *      styles: {
 *        backgroundColor: 'red'
 *      }
 *    }, [h('div.slots')])
 *
 * Follow this tutorial to learn more
 *    https://maquettejs.org/tutorial/01-intro.html
 */

function render() {
  return h("div.main", [h("div.slots"), h("div.scoreboard"), h("div.toolbar")]);
}

projector.append(document.body, render);
