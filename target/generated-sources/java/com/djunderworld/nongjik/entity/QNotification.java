package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QNotification is a Querydsl query type for Notification
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QNotification extends EntityPathBase<Notification> {

    private static final long serialVersionUID = -1156248455L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNotification notification = new QNotification("notification");

    public final QBase _super = new QBase(this);

    public final QBehavior behavior;

    public final NumberPath<Integer> checked = createNumber("checked", Integer.class);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> navigationCategoryId = createNumber("navigationCategoryId", Long.class);

    public final NumberPath<Long> navigationId = createNumber("navigationId", Long.class);

    public final NumberPath<Long> receiverCategoryId = createNumber("receiverCategoryId", Long.class);

    public final NumberPath<Long> receiverId = createNumber("receiverId", Long.class);

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUser user;

    public final ListPath<UserNotification, QUserNotification> userNotifications = this.<UserNotification, QUserNotification>createList("userNotifications", UserNotification.class, QUserNotification.class, PathInits.DIRECT2);

    public QNotification(String variable) {
        this(Notification.class, forVariable(variable), INITS);
    }

    public QNotification(Path<? extends Notification> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNotification(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNotification(PathMetadata<?> metadata, PathInits inits) {
        this(Notification.class, metadata, inits);
    }

    public QNotification(Class<? extends Notification> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.behavior = inits.isInitialized("behavior") ? new QBehavior(forProperty("behavior")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

