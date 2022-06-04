import {podiums} from '@/store/podiums'
import {festival} from "@/domain/Festival";

describe('simple', ()=> {
  it(' first', ()=>{
     expect(podiums.data.length).toBe(5);
     podiums.data[0].filtered = true;
     expect(podiums.filter().length).toBe(1);

  })
});
describe('festival stuff',()=>{
    it("dus",()=>{
        
    })
})
