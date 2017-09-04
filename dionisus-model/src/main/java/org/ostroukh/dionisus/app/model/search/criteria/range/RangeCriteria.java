package org.ostroukh.dionisus.app.model.search.criteria.range;

/**
 * Pagination parameters
 * @author Eugene Ostroukh
 */
public class RangeCriteria {
    /**
     *Page index (0-based)
     */
    private final int page;

    /**
     * Number of elements per page
     */
    private final int rowCount;

    public RangeCriteria(int page, int rowCount) {
        this.page = page;
        this.rowCount = rowCount;
    }

    public int getPage() {
        return page;
    }

    public int getRowCount() {
        return rowCount;
    }
}
