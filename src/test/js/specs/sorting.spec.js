require(["sorting","knockout","jquery"],function(s,ko,$){

    describe("Sorting", function(){
        var collectionToSort = null;

        beforeEach(function(){
            collectionToSort =  ko.observableArray([
                {
                    name: 'tra',
                    amount: null,
                    account: {
                        name: 'nl49'
                    }
                },
                {
                    name: 'lala',
                    amount: 866968,
                    account: {
                        name: 'nl48'
                    }
                },
                {
                    name: 'zum',
                    amount: 8,
                    account: {
                        name: null
                    }
                },
                {
                    name: null,
                    amount: 766,
                    account: {
                        name: 'nl49'
                    }
                },
                {
                    name: 'a',
                    amount: 56,
                    account: null
                }
            ]);
            s.sortable(collectionToSort);

            collectionToSort.subscribe(function(newValue){
                console.log("Test ");
                $.each(collectionToSort(),function(i,item){
                   console.log(i + ": name " + item.name + ", amount: " + item.amount + ", account: " + s.value(item,"account.name"));

                })
            })
        });




        it("should sort on column",function(){
            collectionToSort.sortOnProperty({
                    property: 'name',
                    asc:true
                },
                true);
            expect(collectionToSort()[0].name).toEqual(null);
            expect(collectionToSort()[1].name).toEqual('a');
        });

        it("should sort on column desc",function(){
            collectionToSort.sortOnProperty({
                property:'name',
                asc: false
            });

            expect(collectionToSort()[0].name).toEqual('zum');
        });

        it("should sort on column desc",function(){
            collectionToSort.sortOnProperty({
                property:'amount',
                asc: true
            });

            expect(collectionToSort()[0].amount).toBeNull();
            expect(collectionToSort()[1].amount).toBe(8);
        });

        it("should sort on nested object desc",function(){
            collectionToSort.sortOnProperty({
                property:'account.name',
                asc: true
            });
            expect(collectionToSort()[0].account).toBeNull();
            expect(collectionToSort()[1].account.name).toBeNull();
            expect(collectionToSort()[2].account.name).toBe('nl48');
        });
    });

    describe("Value",function(){
        it("should return a nested value",function(){
             expect(s.value({a:{b:'c'}},"a.b")).toEqual('c');
        });
    });
});