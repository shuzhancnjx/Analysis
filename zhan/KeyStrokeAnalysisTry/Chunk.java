package zhan.KeyStrokeAnalysisTry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import java.io.Closeable;

@Builder()
@ToString
public class Chunk implements Cloneable {

    public @NonNull String chunk;
    public @NonNull Integer startPos;
    public @NonNull Integer endPos; // not included;
    public @NonNull String actionApplied;
    public @NonNull String startTime;
    public @NonNull String endTime;

    @Override
    public Chunk clone(){
        return new Chunk(this.chunk,
                this.startPos,
                this.endPos,
                this.actionApplied,
                this.startTime,
                this.endTime); }
}
