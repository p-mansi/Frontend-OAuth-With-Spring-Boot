import axios from 'axios';
import React, { useEffect, useState } from "react";

const Dashboard = () => {

    const [user, setUser] = useState(null);

    useEffect(() => {
        axios.get('http://localhost:9090/user-info' , {withCredentials: true})
            .then(response => {
                setUser(response.data);
            })
            .catch(error => {
                console.error('Error Occured: ',error);
            })
    }, []);
    return (
        <div>
            <h2>User Info</h2>
            {user ? (
                <div>
                    <p><strong>Name : </strong> {user.name}</p>
                    <p><strong>Email : </strong> {user.email}</p>
                </div>
            ) : (
                <p>Loading User Data...</p>
            )}
            
        </div>
    );
}

export default Dashboard;