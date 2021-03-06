import {festival} from "@/domain/Festival";

let fest;
beforeEach(() => {
    const bks = require('../../../src/main/resources/bks_parsed.json')
    fest = new festival(bks.dagen);
});
describe('festival stuff',()=>{
    it("toggledagen",()=>{
       //we start with this:
        expect(fest.view.dagen[0].wanted).toBe(true);
        expect(fest.view.dagen[1].wanted).toBe(true);
        expect(fest.view.dagen[2].wanted).toBe(true);
        expect(fest.view.dagen[3].wanted).toBe(true);
        expect(fest.view.dagen[4].wanted).toBe(false);
       fest.view.toggleDag(1);
       expect(fest.view.dagen[0].wanted).toBe(true);
       expect(fest.view.dagen[1].wanted).toBe(true);
       expect(fest.view.dagen[2].wanted).toBe(false);
       expect(fest.view.dagen[3].wanted).toBe(true);
       expect(fest.view.dagen[4].wanted).toBe(false);
       expect(fest.dagen.length).toBe(3);
    })
    test("toggledagen op alles",()=>{
        expect(fest.view.dagen[0].wanted).toBe(true);
        expect(fest.view.dagen[1].wanted).toBe(true);
        expect(fest.view.dagen[2].wanted).toBe(true);
        expect(fest.view.dagen[3].wanted).toBe(true);
        expect(fest.view.dagen[4].wanted).toBe(false);
        fest.view.toggleDag(-2);
        expect(fest.view.dagen[0].wanted).toBe(false);
        expect(fest.view.dagen[1].wanted).toBe(false);
        expect(fest.view.dagen[2].wanted).toBe(false);
        expect(fest.view.dagen[3].wanted).toBe(false);
        expect(fest.view.dagen[4].wanted).toBe(false);

    })
    test('toggle op fav',()=>{
        //we start with all days
        expect(fest.view.dagen[0].wanted).toBe(true);
        expect(fest.view.dagen[1].wanted).toBe(true);
        expect(fest.view.dagen[2].wanted).toBe(true);
        expect(fest.view.dagen[3].wanted).toBe(true);
        expect(fest.view.dagen[4].wanted).toBe(false);
        // click all to disable all
        fest.view.toggleDag(-2)
        expect(fest.view.dagen[0].wanted).toBe(false);
        expect(fest.view.dagen[1].wanted).toBe(false);
        expect(fest.view.dagen[2].wanted).toBe(false);
        expect(fest.view.dagen[3].wanted).toBe(false);
        // now toggle the favs
        fest.view.toggleDag(4)
        expect(fest.view.dagen[0].wanted).toBe(false);
        expect(fest.view.dagen[1].wanted).toBe(false);
        expect(fest.view.dagen[2].wanted).toBe(false);
        expect(fest.view.dagen[3].wanted).toBe(false);
        expect(fest.view.dagen[4].wanted).toBe(true);
    })
    test("filtering events for a simple day",()=>{
        // try with only zondag
        fest.view.toggleDag(-2)
        fest.view.toggleDag(2)
        let zondagEvents = fest.filterEvents();
        expect(zondagEvents.length).toBe(19);
     })
})
