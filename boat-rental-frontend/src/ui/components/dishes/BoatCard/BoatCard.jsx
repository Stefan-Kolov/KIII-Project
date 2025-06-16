import React, {useState} from 'react';
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import {Card, CardContent, Typography, CardActions, Button, Box} from '@mui/material';
import EditBoatDialog from "../EditBoatDialog/EditBoatDialog.jsx";
import DeleteDishDialog from "../DeleteBoatDialog/DeleteBoatDialog.jsx";
import {useNavigate} from "react-router";
import DeleteBoatDialog from "../DeleteBoatDialog/DeleteBoatDialog.jsx";

const BoatCard = ({boat, onEdit, onDelete}) => {
    const navigate = useNavigate();

    const [editBoatDialogOpen, setEditBoatDialogOpen] = useState(false);
    const [deleteBoatDialogOpen, setDeleteBoatDialogOpen] = useState(false);

    return (
        <>
            <Card
                sx={{
                    borderRadius: 2,
                    p: 1,
                    flexGrow: 1,
                    display: "flex",
                    flexDirection: "column",
                    justifyContent: "space-between"
                }}
                className="card"
                data-id={boat.id}
            >
                <CardContent sx={{pb: 0}}>
                    <Typography gutterBottom variant="h5" component="div" className="dish-name">
                        {boat.name}
                    </Typography>
                    <Typography variant="body2" color="text.secondary" sx={{mb: 1.5}}  className="dish-desc">
                        {boat.description}
                    </Typography>
                    <Typography variant="body2" color="text.secondary" sx={{mb: 1.5}}  className="dish-desc">
                        {boat.location}
                    </Typography>
                    <Typography variant="body2" color="text.secondary" sx={{mb: 1.5}}  className="dish-desc">
                        {boat.status}
                    </Typography>
                    <Box display="flex" justifyContent="space-between" alignItems="center">
                        <Typography variant="body1" sx={{fontWeight: 'bold'}}>
                            ${boat.price.toFixed(2)}
                        </Typography>
                        <Typography variant="body2" color={boat.capacity > 0 ? 'success.main' : 'error.main'}>
                            {boat.capacity > 0 ? `In Stock: ${boat.capacity}` : 'Out of stock'}
                        </Typography>
                    </Box>
                </CardContent>
                <CardActions sx={{justifyContent: "space-between"}}>
                    <Button
                        size="small"
                        color="info"
                        startIcon={<InfoIcon/>}
                        onClick={() => navigate(`/boats/${boat.id}`)}
                        className="info-item"
                    >
                        Info
                    </Button>
                    <Box>
                        <Button
                            size="small"
                            color="warning"
                            startIcon={<EditIcon/>}
                            sx={{mr: "0.25rem"}}
                            onClick={() => setEditBoatDialogOpen(true)}
                            className="edit-item"
                        >
                            Edit
                        </Button>
                        <Button
                            size="small"
                            color="error"
                            startIcon={<DeleteIcon/>}
                            onClick={() => setDeleteBoatDialogOpen(true)}
                            className="delete-item"
                        >
                            Delete
                        </Button>
                    </Box>
                </CardActions>
            </Card>
            <EditBoatDialog
                open={editBoatDialogOpen}
                onClose={() => setEditBoatDialogOpen(false)}
                onEdit={onEdit}
                boat={boat}
            />
            <DeleteBoatDialog
                open={deleteBoatDialogOpen}
                onClose={() => setDeleteBoatDialogOpen(false)}
                onDelete={onDelete}
                boat={boat}
            />
        </>
    );
};

export default BoatCard;