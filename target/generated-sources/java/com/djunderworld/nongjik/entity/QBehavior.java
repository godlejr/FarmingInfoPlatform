package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBehavior is a Querydsl query type for Behavior
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBehavior extends EntityPathBase<Behavior> {

    private static final long serialVersionUID = -307942176L;

    public static final QBehavior behavior = new QBehavior("behavior");

    public final QBase _super = new QBase(this);

    //inherited
    public final StringPath createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final ListPath<Notification, QNotification> notifications = this.<Notification, QNotification>createList("notifications", Notification.class, QNotification.class, PathInits.DIRECT2);

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public QBehavior(String variable) {
        super(Behavior.class, forVariable(variable));
    }

    public QBehavior(Path<? extends Behavior> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBehavior(PathMetadata<?> metadata) {
        super(Behavior.class, metadata);
    }

}

