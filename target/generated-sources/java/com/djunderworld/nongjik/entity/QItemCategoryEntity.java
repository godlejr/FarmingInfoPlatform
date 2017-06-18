package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QItemCategoryEntity is a Querydsl query type for ItemCategoryEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QItemCategoryEntity extends EntityPathBase<ItemCategoryEntity> {

    private static final long serialVersionUID = -1683594878L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemCategoryEntity itemCategoryEntity = new QItemCategoryEntity("itemCategoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QCategoryEntity categoryEntity;

    //inherited
    public final StringPath createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final ListPath<StoryEntity, QStoryEntity> storyEntities = this.<StoryEntity, QStoryEntity>createList("storyEntities", StoryEntity.class, QStoryEntity.class, PathInits.DIRECT2);

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public QItemCategoryEntity(String variable) {
        this(ItemCategoryEntity.class, forVariable(variable), INITS);
    }

    public QItemCategoryEntity(Path<? extends ItemCategoryEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QItemCategoryEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QItemCategoryEntity(PathMetadata<?> metadata, PathInits inits) {
        this(ItemCategoryEntity.class, metadata, inits);
    }

    public QItemCategoryEntity(Class<? extends ItemCategoryEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoryEntity = inits.isInitialized("categoryEntity") ? new QCategoryEntity(forProperty("categoryEntity")) : null;
    }

}

