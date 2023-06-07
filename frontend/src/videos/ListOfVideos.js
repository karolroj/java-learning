import React from 'react';

export default class ListOfVideos extends React.Component {
    constructor(props) {
        super(props);
        this.state = { data: [] };
    }

    async componentDidMount() {
        let json = await fetch("http://localhost:8080/api/videos").then(res => res.json());
        this.setState({ data: json });
    }

    render() {
        console.log(this.state.data);
        return (
            <ul>
                {this.state.data.map(item => <li>{item.name}</li>)}
            </ul>
        )
    }
}