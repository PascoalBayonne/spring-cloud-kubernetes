ConfigMaps allow you to decouple configuration artifacts from image content to keep containerized applications portable.

You can use either kubectl create configmap or a ConfigMap generator in kustomization.yaml to create a ConfigMap. Note that kubectl starts to support kustomization.yaml since 1.14.

Create a ConfigMap Using kubectl create configmap
Use the kubectl create configmap command to create ConfigMaps from directories, files, or literal values:

kubectl create configmap <map-name> <data-source>