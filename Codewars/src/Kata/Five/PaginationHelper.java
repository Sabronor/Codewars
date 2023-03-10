package Kata.Five;

import java.util.List;

/**
 * For this exercise you will be strengthening your page-fu mastery.
 * You will complete the PaginationHelper class, which is a utility class helpful for querying paging information
 * related to an array.
 *
 * The class is designed to take in an array of values and an integer indicating how many items will be allowed per
 * each page. The types of values contained within the collection/array are not relevant.
 */
public class PaginationHelper<I> {
    List<I> content;
    int itemsPerPage;
    /**
     * The constructor takes in an array of items and an integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.content = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return content.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (int) Math.ceil((double) content.size() / itemsPerPage);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex > pageCount() - 1 || pageIndex < 0) return -1;
        return pageIndex == pageCount() - 1? content.size() % itemsPerPage : itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex > content.size() - 1 || itemIndex < 0) return -1;
        return itemIndex / itemsPerPage;
    }
}
