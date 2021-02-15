export default class VehicleService{

    constructor(resource) {
        this._resource = resource('/api/v1/vehicle/{id}');
    }

    recoverAll() {
        return this._resource
            .query()
            .then(res => res.json(), err=>{
                console.log(err);
                throw new Error('Não foi possivel obter os veiculos.');
            });
    }

    save(vehicle) {
        if (vehicle._id) {
            return this._resource
                .update({ id: vehicle._id }, vehicle);
        }
        else {
            return this._resource
                .save(vehicle);
        }
    }

    delete(id) {
        return this._resource
                .delete({ id })
                .then(null, err=>{
                    console.log(err);
                    throw new Error('Não foi possivel remover o veiculo.');
                });

    }

    recoverById(id) {
        return this._resource
            .get({ id })
            .then(res => res.json());
    }
}