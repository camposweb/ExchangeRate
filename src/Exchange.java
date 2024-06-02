import java.util.Date;

public record Exchange(
        String result,
        String time_last_update_utc,
        String time_next_update_utc,
        float conversion_result
) {
}
