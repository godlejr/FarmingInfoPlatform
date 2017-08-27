package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUserNotification is a Querydsl query type for UserNotification
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserNotification extends EntityPathBase<UserNotification> {

    private static final long serialVersionUID = 1842117860L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserNotification userNotification = new QUserNotification("userNotification");

    public final QBase _super = new QBase(this);

    //inherited
    public final StringPath createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QNotification notification;

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUser user;

    public QUserNotification(String variable) {
        this(UserNotification.class, forVariable(variable), INITS);
    }

    public QUserNotification(Path<? extends UserNotification> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserNotification(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserNotification(PathMetadata<?> metadata, PathInits inits) {
        this(UserNotification.class, metadata, inits);
    }

    public QUserNotification(Class<? extends UserNotification> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.notification = inits.isInitialized("notification") ? new QNotification(forProperty("notification"), inits.get("notification")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

