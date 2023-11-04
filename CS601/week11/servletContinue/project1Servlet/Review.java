package week11.servletContinue.project1Servlet;

public class Review {
    private String hotelId;
    private String reviewId;
    private double ratingOverall;
    private String title;
    private String reviewText;
    private String userNickname;
    private String reviewSubmissionTime;

    public Review(String hotelId, String reviewId, double ratingOverall, String title, String reviewText, String userNickname, String reviewSubmissionTime) {
        this.hotelId = hotelId;
        this.reviewId = reviewId;
        this.ratingOverall = ratingOverall;
        this.title = title;
        this.reviewText = reviewText;
        this.userNickname = userNickname;
        this.reviewSubmissionTime = reviewSubmissionTime;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getReviewSubmissionTime() {
        return reviewSubmissionTime;
    }

    public String getReviewId() {
        return reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getUserNickname() {
        if (userNickname == null || userNickname.length() == 0) {
            return "Anonymous";
        }
        return userNickname;
    }

    public int getRatingOverall() {
        return (int) ratingOverall;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "--------------------" + System.lineSeparator() +
            "Review by " + getUserNickname() + " on " + getReviewSubmissionTime().substring(0, 10) + System.lineSeparator() +
            "Rating: " + getRatingOverall() + System.lineSeparator() +
            "ReviewId: " + getReviewId() + System.lineSeparator() +
            getTitle() + System.lineSeparator() +
            getReviewText();
    }
}
