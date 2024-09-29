package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 *
 * BeanDefinition 注册表接口
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        // 这里的逻辑是，如果当前的bean是一个单例bean，那就返回其实例对象
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        // 如果不是单例,那就去容器中获取其BeanDefinition,然后通过其子类实现create一个实例
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
