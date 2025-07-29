import React from "react";

const Home = () => {

    const googleLogin = () => {
        window.location.href = 'http://localhost:9090/oauth2/authorization/google'
    };
    const githubLogin = () => {
        window.location.href = 'http://localhost:9090/oauth2/authorization/github'
    };
    return (
        <div>
            <h2>Welcome to OAuth Demo</h2>
            <button onClick={googleLogin}>Login with Google</button>
            <button onClick={githubLogin}>Login with GitHub</button>
        </div>
    );

}
export default Home;