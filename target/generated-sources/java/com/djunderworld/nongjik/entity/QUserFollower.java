package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUserFollower is a Querydsl query type for UserFollower
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserFollower extends EntityPathBase<UserFollower> {

    private static final long serialVersionUID = 2077358231L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserFollower userFollower = new QUserFollower("userFollower");

    public final QBase _super = new QBase(this);

    //inherited
    public final StringPath createdAt = _super.createdAt;

    public final QUser follower;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUser user;

    public QUserFollower(String variable) {
        this(UserFollower.class, forVariable(variable), INITS);
    }

    public QUserFollower(Path<? extends UserFollower> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserFollower(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserFollower(PathMetadata<?> metadata, PathInits inits) {
        this(UserFollower.class, metadata, inits);
    }

    public QUserFollower(Class<? extends UserFollower> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.follower = inits.isInitialized("follower") ? new QUser(forProperty("follower"), inits.get("follower")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

