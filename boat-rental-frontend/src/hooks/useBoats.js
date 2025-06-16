import {useCallback, useEffect, useState} from "react";
import boatRepository from "../repository/boatRepository.js";

const initialState = {
    boats: [],
    loading: true,
};

const useBoats = () => {
    const [state, setState] = useState(initialState);

    const fetchBoats = useCallback(() => {
        setState({
            boats: [],
            loading: true,
        });
        boatRepository
            .findAll()
            .then((response) => {
                setState({
                    boats: response.data,
                    loading: false,
                });
            });
    }, []);

    const onAdd = useCallback((data) => {
        boatRepository
            .add(data)
            .then(() => fetchBoats())
            .catch((error) => console.log(error));
    }, [fetchBoats]);

    const onEdit = useCallback((id, data) => {
        boatRepository
            .edit(id, data)
            .then(() => fetchBoats())
            .catch((error) => console.log(error));
    }, [fetchBoats]);

    const onDelete = useCallback((id) => {
        boatRepository
            .delete(id)
            .then(() => fetchBoats())
            .catch((error) => console.log(error));
    }, [fetchBoats]);

    useEffect(() => {
        fetchBoats();
    }, [fetchBoats]);

    return {...state, onAdd, onEdit, onDelete};
};

export default useBoats;