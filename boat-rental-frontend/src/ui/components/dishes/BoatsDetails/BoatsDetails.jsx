import React from 'react';
import {useNavigate, useParams} from "react-router";
import {
    Box,
    Button,
    CircularProgress,
    Typography,
    Paper,
    Stack,
    Chip,
    Breadcrumbs,
    Link
} from "@mui/material";
import {
    ArrowBack,
    Restaurant,
    ShoppingCart
} from "@mui/icons-material";
import useBoatsDetails from "../../../../hooks/useBoatsDetails.js";
import boatRepository from "../../../../repository/boatRepository.js";

const BoatsDetails = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const boat = useBoatsDetails(id);

    if (!boat) {
        return (
            <Box sx={{display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '60vh'}}>
                <CircularProgress/>
            </Box>
        );
    }

    const addToOrder = () => {
        boatRepository
            .addToOrder(id)
            .then(() => console.log(`Successfully ordered boat with ID ${id}.`))
            .catch((error) => console.log(error));
    };

    return (
        <Box width={750} mx="auto" mt={3}>
            <Breadcrumbs aria-label="breadcrumb" sx={{mb: 3}}>
                <Link
                    underline="hover"
                    color="inherit"
                    href="#"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate("/boats");
                    }}
                >
                    Boats
                </Link>
                <Typography color="text.primary">{boat.name}</Typography>
            </Breadcrumbs>

            <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                <Stack spacing={3}>
                    <Typography variant="h4" fontWeight={600} className="dish-name">
                        {boat.name}
                    </Typography>

                    <Typography variant="body1" color="text.secondary" className="dish-desc">
                        {boat.description || "No description provided."}
                    </Typography>

                    <Typography variant="body1" color="text.secondary" className="dish-desc">
                        {boat.location || "No location provided."}
                    </Typography>

                    <Typography variant="h5" color="primary.main" className="dish-price">
                        ${boat.price}
                    </Typography>

                    <Typography variant="subtitle1"  className="dish-quantity">
                        Capacity - {boat.capacity}
                    </Typography>

                    <Chip
                        icon={<Restaurant />}
                        label={boat.category.name}
                        className="restaurant-name"
                        color="secondary"
                        variant="outlined"
                        sx={{width: "fit-content", p: 2}}
                    />

                    <Stack direction="row" justifyContent="space-between" spacing={2} mt={2}>
                        <Button
                            variant="contained"
                            color="primary"
                            startIcon={<ShoppingCart />}
                            onClick={addToOrder}
                            className="add-to-order"
                        >
                            Order Now
                        </Button>
                        <Button
                            variant="outlined"
                            startIcon={<ArrowBack />}
                            onClick={() => navigate("/boats")}
                        >
                            Back to Boats
                        </Button>
                    </Stack>
                </Stack>
            </Paper>
        </Box>
    );
};

export default BoatsDetails;
