import axiosInstance from "../axios/axios.js";

const boatRepository = {
    findAll: async () => {
        return await axiosInstance.get("/boats");
    },
    findByIdWithDetails: async (id) => {
        return await axiosInstance.get(`/boats/${id}/details`);
    },
    add: async (data) => {
        return await axiosInstance.post("/boats/add", data);
    },
    edit: async (id, data) => {
        return await axiosInstance.put(`/boats/${id}/edit`, data);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/boats/${id}/delete`);
    },
    addToOrder: async (id) => {
        return await axiosInstance.post(`/boats/${id}/add-to-order`);
    },
    removeFromOrder: async (id) => {
        return await axiosInstance.post(`/boats/${id}/remove-from-order`);
    },
};

export default boatRepository;