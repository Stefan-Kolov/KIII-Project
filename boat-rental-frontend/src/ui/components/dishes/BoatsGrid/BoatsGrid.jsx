import React from 'react';
import {Grid} from "@mui/material";
import BoatCard from "../BoatCard/BoatCard.jsx";

const BoatsGrid = ({boats, onEdit, onDelete}) => {
    return (
        <Grid container spacing={{xs: 2, md: 3}}>
            {boats.map((boat) => (
                <Grid key={boat.id} size={{xs: 12, sm: 6, md: 4, lg: 3}} display="flex">
                    <BoatCard boat={boat} onEdit={onEdit} onDelete={onDelete}/>
                </Grid>
            ))}
        </Grid>
    );
};

export default BoatsGrid;