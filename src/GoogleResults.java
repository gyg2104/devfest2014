import java.util.List;

/**
 * parses json
 * @author chris wang
 *
 */
public class GoogleResults {
	private Queries queries;
    public Queries getQueries() { return queries; }
    public void setQueries(Queries queries) { this.queries = queries; }
    public String toString() { return "Queries[" + queries + "]"; }

    static class Queries {
        private List<Request> request;
        public List<Request> getRequests() { return request; }
        public void setRequests(List<Request> request) { this.request = request; }
        public String toString() { return "Requests[" + request + "]"; }
    }

    static class Request {
        private String totalResults;
        public String getTotalResults() { return totalResults; }
        public void setTotalResults(String totalResults) { this.totalResults = totalResults; }
        public String toString() { return totalResults; }
    }
}
