import service from "../service/NetworkingService.js"

export default {
    async getCryptos() {
        try {
            let response = await service.get("/api/cryptos")
            return response.data
        }
        catch(error) {
            console.log(error)
            console.log("siin on probleem")
        }
    }
}
