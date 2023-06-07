import React from "react";

export default class NewVideo extends React.Component {
    constructor(props){
        super(props);
        this.state = {name: ""};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event){
        this.setState({name: event.target.value});
    }

    async handleSubmit(event){
        event.preventDefault();
        await fetch("http://localhost:8080/api/video", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({name: this.state.name})
        }).then(res => window.location.reload());
    }

    render() {
        return( 
            <form onSubmit={this.handleSubmit}>
                <input type="text" value={this.state.name} onChange={this.handleChange} />
                <input type="submit" value="Add" />
            </form>
        )
    }
}