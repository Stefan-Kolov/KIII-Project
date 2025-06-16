import React, {useState} from 'react';
import {Box, Button, CircularProgress} from "@mui/material";
import "./BoatsPage.css";
import useBoats from "../../../hooks/useBoats.js";
import BoatsGrid from "../../components/dishes/BoatsGrid/BoatsGrid.jsx";
import AddBoatDialog from "../../components/dishes/AddBoatDialog/AddBoatDialog.jsx";

const ProductsPage = () => {
    const {boats, loading, onAdd, onEdit, onDelete} = useBoats();

    const [addBoatDialogOpen, setAddBoatDialogOpen] = useState(false);

    return (
        <>
            <Box className="dishes-box">
                <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => setAddBoatDialogOpen(true)}
                        className="add-item"
                    >
                        Add Boat
                    </Button>
                </Box>
                {loading && <Box className="progress-box"><CircularProgress/></Box>}
                {!loading && <BoatsGrid boats={boats} onEdit={onEdit} onDelete={onDelete}/>}
            </Box>
            <AddBoatDialog
                open={addBoatDialogOpen}
                onClose={() => setAddBoatDialogOpen(false)}
                onAdd={onAdd}
            />
        </>
    );
};

export default ProductsPage;