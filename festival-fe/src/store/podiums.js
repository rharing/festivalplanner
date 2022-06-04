export const podiums={
    data:[
        {id:0, name: 'ONE', filtered:false}
        ,{id:1, name: 'TWO', filtered:false}
        ,{id:2, name: 'SECRET', filtered:false}
        ,{id:3, name: 'CASBAH', filtered:false}
        ,{id:4, name: 'FLOOR', filtered:false}
    ],
    filter(){
        return this.data.filter(podium=> podium.filtered)
    }
}
