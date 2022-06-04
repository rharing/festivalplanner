export const podiums={
    data:[
        {id:0, name: 'ONE', filtered:false}
        ,{id:1, name: 'TWO', filtered:false}
        ,{id:2, name: 'SECRET', filtered:false}
        ,{id:3, name: 'CASBAH', filtered:false}
        ,{id:4, name: 'FLOOR', filtered:false}
    ],
    filter(){
        let result =[];
        for(let i=0; i<this.data.length;i++){
           let podium = this.data[i];
           if(podium.filtered){
               result.push(podium);
           }
        }
        return result
    }
}
