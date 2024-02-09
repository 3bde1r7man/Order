package aamm.order.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public abstract class NotificationTemplate {

    protected String templateMessage;
    protected String contactInfo;
    protected ContactType contactType;
    protected long id;

}
