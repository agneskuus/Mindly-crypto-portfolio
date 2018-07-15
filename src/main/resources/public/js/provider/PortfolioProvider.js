import service from "../service/NetworkingService.js"

export default {
    async getPortfolioItems() {
        try {
            let response = await service.get("/api/portfolio")
            return response.data
        }
        catch(error) {
            console.log(error)
        }
    }
}
