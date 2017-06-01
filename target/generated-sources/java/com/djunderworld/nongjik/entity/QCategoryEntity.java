package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCategoryEntity is a Querydsl query type for CategoryEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCategoryEntity extends EntityPathBase<CategoryEntity> {

    private static final long serialVersionUID = 1618947727L;

    public static final QCategoryEntity categoryEntity = new QCategoryEntity("categoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final ListPath<ItemCategoryEntity, QItemCategoryEntity> itemCategoryEntities = this.<ItemCategoryEntity, QItemCategoryEntity>createList("itemCategoryEntities", ItemCategoryEntity.class, QItemCategoryEntity.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public QCategoryEntity(String variable) {
        super(CategoryEntity.class, forVariable(variable));
    }

    public QCategoryEntity(Path<? extends CategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoryEntity(PathMetadata<?> metadata) {
        super(CategoryEntity.class, metadata);
    }

}

