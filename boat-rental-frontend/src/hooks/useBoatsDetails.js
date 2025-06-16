import {useEffect, useState} from "react";
import boatRepository from "../repository/boatRepository.js";

const useBoatsDetails = (id) => {
    const [boat, setBoat] = useState(null);

    useEffect(() => {
        boatRepository
        .findByIdWithDetails(id)
        .then((response) => setBoat(response.data))
        .catch((error) => console.log(error));
    }, [id]);

    return boat;
};

export default useBoatsDetails;