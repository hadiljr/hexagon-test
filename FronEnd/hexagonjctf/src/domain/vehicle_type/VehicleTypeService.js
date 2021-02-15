export default class VehicleTypeService{

    constructor(resource) {
        this._resource = resource('/api/v1/vehicletype/{id}');
    }

    recoverAll() {
        return this._resource
            .query()
            .then(res => res.json(), err=>{
                console.log(err);
                throw new Error('Não foi possivel obter os tipos veiculos.');
            });
    }

}