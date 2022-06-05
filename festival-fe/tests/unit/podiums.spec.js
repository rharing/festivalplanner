import {podiums} from '@/domain/podiums'

describe('simple', ()=> {
  it(' first', ()=>{
     expect(podiums.data.length).toBe(5);
     podiums.data[0].filtered = true;
      let filter = podiums.filter();
      expect(filter.length).toBe(1);
expect(filter.name).toBe("ONE");
  })
});
