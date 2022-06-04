import {podiums} from '@/store/podiums'

describe('simple', ()=> {
  it(' first', ()=>{
     expect(podiums.data.length).toBe(5);
     podiums.data[0].filtered = true;
     expect(podiums.filter().length).toBe(1);

  })
});
