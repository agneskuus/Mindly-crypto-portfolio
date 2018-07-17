export default {
    get(url) {
        return axios.get(url)
    },
    post(url, body) {
        return axios.post(url, body)
    },
    delete(url) {
        return axios.delete(url)
    }
}