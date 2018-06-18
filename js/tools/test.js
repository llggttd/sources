let a = {
    name: 'lgt',
    age: 26,
    login: true,
    item: [
        {
            id: 10001,
            name: 'item1'
        },
        {
            id: 10002,
            name: 'item2'
        }
    ]
}

console.log(JSON.stringify(a, undefined, 2))